import React from 'react';
import './ProgressBar.css'; // Assuming you will define styles in ProgressBar.css

const ProgressBar = ({ progress }) => {
  return (
    <div class="progress-container" style={{ width: `${progress}%` }}>
      <div class="progress-bar"></div>
    </div>
  );
};

export default ProgressBar;