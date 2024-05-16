// import React, { useState, useEffect } from 'react';
import React from 'react';
import { useState, useEffect, useRef } from 'react';
import './Cover.css';
import logo from './images/Logo.jpg';
import button from './images/button.gif';
import sta from './images/static.png';
import { useNavigate } from 'react-router-dom';
import $ from 'jquery';

function Cover() {
    // Ref for the logo to directly manipulate the DOM element
    const logoRef = useRef(null);
    const buttonRef = useRef(null);

    const handleButtonClick = () => {
        // Use jQuery to animate the logo element
        $(logoRef.current).animate({
        width: '200px',
        height: '200px', // Shrink width
        top: '0px',   // Move to top
        left: '0px',  // Move to left
        }, 300, function(){
            // navigate('/survey');
        }); 

        $(buttonRef.current).animate({
            top: '100px',
            left: '700px',
        }, 300);
        
    };

    useEffect(() => {
        // Set the body background color to white using hexadecimal
        document.body.style.backgroundColor = '#34495E'; // White color
        
        // Cleanup function to reset the background color when the component unmounts
        return () => {
            document.body.style.backgroundColor = ''; // Revert to the default
            if (logoRef.current) {
                $(logoRef.current).stop(); // Stop any jQuery animation on unmount
            } 
        };
    }, []);

    const navigate = useNavigate();
    const [showButton, setShowButton] = useState(true);
    const [isLogoSmall, setIsLogoSmall] = useState(false);
    const handleSubmit = () => {
        setIsLogoSmall(!isLogoSmall);
        setShowButton(false);
        // navigate('/survey');   
    };

    return(
        <div class='cover-container'>
            <div class='image-container'>
                <p>A more personal recommendation</p>
                <img ref={logoRef}  class='logo' src={logo}></img>
                <div ref={buttonRef} class='button-container'>
                    <img id='animates' class='gif' src={button}></img>
                    <img id='static' class='gif' src={sta}></img>
                    <button class='btn' onClick={handleButtonClick} />
                </div>
            </div>
            
        </div>
    )
}
// class={isLogoSmall ? 'logo-small' : 'logo'}

export default Cover;
