import React from 'react';
import './ProgressBar.css'; // Assuming you will define styles in ProgressBar.css

const ProgressBar = ({ progress }) => {
  return (
    <div className="progress-container" style={{ width: `${progress}%` }}>
      <div className="progress-bar"></div>
    </div>
  );
};

export default ProgressBar;