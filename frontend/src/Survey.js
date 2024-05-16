import React, { useState, useEffect, useRef } from 'react';
import './Survey.css';
import ProgressBar from './ProgressBar.js'; 
import { useNavigate } from 'react-router-dom';
import $ from 'jquery';
import logo from './images/Logo.jpg';
import button from './images/button.gif';
import sta from './images/static.png';
import axios from 'axios';

function Survey() {

    const logoRef = useRef(null);
    const buttonRef = useRef(null);
    const sloganRef = useRef(null);
    const surveycontainerRef = useRef(null);
    const covercontainerRef = useRef(null);
    const colorRef = useRef(null);
    const [next, setNext] = useState(false);
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

        $(sloganRef.current).animate({
            opacity: '0',
        }, 300);

        if (!next) {
            setNext(true);
        } else {
            nextQuestion();
        }
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
            questionText: 'Do you like to leave your software open?',
            options: ['Yes', 'No'],
            type: 'multiple-choice-single'
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
            questionText: 'Do you plan to upgrade your PC in the future?',
            options: ['Yes', 'No'],
            type: 'multiple-choice-single'
        },
        {
            questionText: 'How many tabs do you like to keep open at once?',
            options: ['0-15', '15-30', '30-45'],
            type: 'multiple-choice-single'
        },
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
    const [inputError, setInputError] = useState("");
    const handleOpenEndedChange = (e) => {
        const value = e.target.value;
        // Check if the input value is numeric (integer) or an empty string
        if (/^\d*$/.test(value)) {
            // If numeric, update the answer and clear any error message
            const updatedAnswers = [...answers];
            updatedAnswers[currentQuestionIndex] = value;
            setAnswers(updatedAnswers);
            setInputError(""); // Clear any error message
        } else {
            // If not numeric, set an error message but still allow the input for user correction
            setInputError("Please enter a valid number.");
        }
        const updatedAnswers = [...answers];
        updatedAnswers[currentQuestionIndex] = e.target.value;
        setAnswers(updatedAnswers);
    };

    const nextQuestion = () => {
        if (currentQuestionIndex < questions.length - 1) {
        setCurrentQuestionIndex(currentQuestionIndex + 1);
        setActiveOption(null);
        }
        // } else {
        //   handleSubmit(); // Call submit function when reaching the end of the questions
        // }
    };

    const handleSubmit = async () => {
        // Final submission logic, e.g., send answers to a backend or show a summary
        console.log('Survey completed. Answers:', answers);
        // Add this function inside your Survey component
        // try {
        //     const response = await axios.post('http://optibuild/api/questions', {
        //         answers: answers,
        //         // Include any other data you need to send
        //     });
        //     console.log('Survey submitted successfully:', response.data);
        //     navigate('/submission', { state: { data: response.data } }); // Navigate to a submission success page
        // } catch (error) {
        //     console.error('Failed to submit survey:', error);
        //     // Handle errors, perhaps show a message to the user
        // }
        const url = 'https://sincere-accurately-foal.ngrok-free.app/questions';
        axios.post(url, answers)
            .then(response => {
                // Handle response
                console.log(response.data);
            })
            .catch(error => {
                // Handle error
                console.error("There was an error!", error);
            });
        navigate('/submission')
        // navigate('/submission', { state: { data: response.data } });   
    };

    const renderQuestionInput = (e) => {
        console.log(currentQuestionIndex);
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
                        className='checkbox'
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
                <input className='open-input'
                type='text'
                value={answers[currentQuestionIndex]}
                onChange={handleOpenEndedChange}
                />
                {inputError && <div style={{color: 'red'}}>{inputError}</div>} {/* Display error message */}
                </div>
            );
            }
        }
    };


    return (
        <div className='container'>
            <ProgressBar progress={progress} />
            <div ref={covercontainerRef} className='cover-container'>
                <div className='image-container'>
                    <img ref={logoRef}  className='logo' src={logo}></img>
                    <h2 ref={sloganRef} className='slogan'>A more personal recommendation</h2>
                    <div ref={buttonRef} className='button-container'>
                        <img id='animates' className='gif' src={button}></img>
                        <img id='static' className='gif' src={sta}></img>
                        <button className='btn' onClick={handleButtonClick} />
                    </div>
                </div>
            </div>
            <div ref={surveycontainerRef} id='survey' className='survey-container'>
                <div className='question-container'>
                    <h2>{questions[currentQuestionIndex].questionText}</h2>
                    <div className='question-render'>{renderQuestionInput(0)}</div>
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
