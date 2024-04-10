import React, { useState, useEffect, useRef } from 'react';
import './Survey.css';
import ProgressBar from './ProgressBar.js'; 
import { useNavigate } from 'react-router-dom';
import $ from 'jquery';
import logo from './images/Logo.jpg';
import button from './images/button.gif';
import sta from './images/static.png';

function Survey() {

    const logoRef = useRef(null);
    const buttonRef = useRef(null);
    const surveycontainerRef = useRef(null);
    const covercontainerRef = useRef(null);
    const colorRef = useRef(null);
    const handleButtonClick = () => {
        // Use jQuery to animate the logo element
        // $('.logo').css('position', 'fixed')
        $(logoRef.current).animate({
        width: '200px',
        height: '200px', // Shrink width
        top: '-300px',   // Move to top
        left: '-650px',  // Move to left
        }, 300, function(){
            // navigate('/survey');
        }); 

        $(buttonRef.current).animate({
            top: '-100px',
            left: '790px',
        }, 300, function(){
            $(surveycontainerRef.current).animate({
                opacity: '100%',
            }, 500);
            $('.survey-container').css('z-index', '20');
        });
        nextQuestion();
    };

    useEffect(() => {
        // Set the body background color to a specific blue using hexadecimal
        document.body.style.backgroundColor = '#34495E'; // Example blue color
        
        // Cleanup function to reset the background color when the component unmounts
        return () => {
            document.body.style.backgroundColor = '';
            if (logoRef.current) {
                $(logoRef.current).stop(); // Stop any jQuery animation on unmount
            };
            if (buttonRef.current) {
                $(buttonRef.current).stop();
            }
        };
    }, []);
    const questions = [
        {
            questionText: 'What is your budget?',
            type: 'open-ended'
        },
        { 
            questionText: 'What specific programs will you be using?', 
            options: ['Adobe Premiere Pro', 'Adobe After Effects', 'Adobe Photoshop', 'General work'], 
            type: 'multiple-choice-multiple' 
        },
        { 
            questionText: 'Will you be playing games?', 
            options: ['Yes', 'No'], 
            type: 'multiple-choice-single' 
        },
        { 
            questionText: 'How much storage do you think you will need?', 
            options: ['250 GB - 500 GB', '500GB - 1TB', '1TB - 2TB', '2TB - 4TB', '4TB+'],
            type: 'multiple-choice-single' 
        },
        {
            questionText: 'Where do you plan to place your PC?',
            options: ['Limited space', 'Unlimited space'],
            type: 'multiple-choice-single'
        },
        {
            questionText: 'Do you like to leave your software open?',
            options: ['Yes', 'No'],
            type: 'multiple-choice-single'
        },
        {
            questionText: 'Do you plan to upgrade your PC in the future?',
            options: ['Yes', 'No'],
            type: 'multiple-choice-single'
        }
    ];

    const followqs = [
        {
            questionText: 'What specific games do you play?',
            type: 'open-ended'
        },
        {
            questionText: 'Do you keep an average of more than 6 programs open?',
            options: ['Yes', 'No'],
            type: 'multiple-choice-single'
        }
    ];
    const navigate = useNavigate();
    const [currentQuestionIndex, setCurrentQuestionIndex] = useState(0);
    const [answers, setAnswers] = useState(Array(questions.length).fill(''));
    const progress = (currentQuestionIndex / (questions.length - 1)) * 100;
    const [activeOption, setActiveOption] = useState(null);
    const handleOptionClick = (option) => {
        console.log(option);
        if (questions[currentQuestionIndex].type === 'multiple-choice-multiple') {
        let updatedAnswers = [...answers];
        let currentAnswers = updatedAnswers[currentQuestionIndex];
        if (typeof currentAnswers === 'string') currentAnswers = [];
        
        const optionIndex = currentAnswers.indexOf(option);
        if (optionIndex > -1) {
            // Remove the option
            currentAnswers.splice(optionIndex, 1);
        } else {
            // Add the option
            currentAnswers.push(option);
        }
        updatedAnswers[currentQuestionIndex] = currentAnswers;
        setAnswers(updatedAnswers);
        } else {

            const updatedAnswers = [...answers];
            updatedAnswers[currentQuestionIndex] = option;
            setAnswers(updatedAnswers);
            // if ((currentQuestionIndex == 5 && option == 'Yes') || (currentQuestionIndex == 2 && option == 'Yes')){

            // }
            // Proceed to the next question or submit if it's the last question
            // handleColorChange();
            setActiveOption(option);
            // nextQuestion();
        }
    };

    const handleOpenEndedChange = (e) => {
        const updatedAnswers = [...answers];
        console.log(e.target.value);
        updatedAnswers[currentQuestionIndex] = e.target.value;
        setAnswers(updatedAnswers);
    };

    const nextQuestion = () => {
        if (currentQuestionIndex < questions.length - 1) {
        setCurrentQuestionIndex(currentQuestionIndex + 1);
        }
        // } else {
        //   handleSubmit(); // Call submit function when reaching the end of the questions
        // }
    };

    const handleSubmit = () => {
        // Final submission logic, e.g., send answers to a backend or show a summary
        console.log('Survey completed. Answers:', answers);
        navigate('/submission');   
    };

    const renderQuestionInput = (e) => {
        if(e == 0){
            const question = questions[currentQuestionIndex];
            if (question.type === 'multiple-choice-single') {
            return question.options.map((option) => (
                <div>
                    <button className={`multiple-button ${activeOption === option ? 'active' : ''}`} key={option} onClick={() => handleOptionClick(option)}>
                    {option}
                    </button>
                </div>
            ));
            } else if (question.type === 'multiple-choice-multiple') {
            return question.options.map((option) => (
                <div className="options-container">
                    <div key={option} className='option' style={{marginRight: '10px' }}>
                    <input 
                        class='checkbox'
                        type='checkbox'
                        id={option}
                        name={option}
                        // checked={answers[currentQuestionIndex].includes(option)}
                        onChange={() => handleOptionClick(option)}
                    />
                    <label htmlFor={option} className='label'>{option}</label>
                    </div>
                </div>
            ));
            } else if (question.type === 'open-ended') {
            return (
                <div>
                <input class='open-input'
                type='text'
                value={answers[currentQuestionIndex]}
                onChange={handleOpenEndedChange}
                />
                </div>
            );
            }
        }
    };


    return (
        <div class='container'>
            <ProgressBar progress={progress} />
            <div ref={covercontainerRef} class='cover-container'>
                <div class='image-container'>
                    <img ref={logoRef}  class='logo' src={logo}></img>
                    <div ref={buttonRef} class='button-container'>
                        <img id='animates' class='gif' src={button}></img>
                        <img id='static' class='gif' src={sta}></img>
                        <button class='btn' onClick={handleButtonClick} />
                    </div>
                </div>
            </div>
            <div ref={surveycontainerRef} id='survey' class='survey-container'>
                <div class='question-container'>
                    <h2>{questions[currentQuestionIndex].questionText}</h2>
                    <div class='question-render'>{renderQuestionInput(0)}</div>
                    {currentQuestionIndex < questions.length - 1 ? (
                        // questions[currentQuestionIndex].type !== 'multiple-choice-single' ? 
                        //     <button onClick={nextQuestion}>Skip</button>
                        //     :
                        //     null
                            <button className='skipbutton' onClick={nextQuestion}>Skip</button>
                        ) : (
                        <button onClick={handleSubmit}>Let's Build</button>
            )}
                    {/* {questions[currentQuestionIndex].type === 'open-ended' && (
                    <button onClick={nextQuestion}>Next (for open-ended)</button>
                    )} */}
                </div>
            </div>
        </div>
    );
}

export default Survey;
