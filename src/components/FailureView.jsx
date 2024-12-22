import React from 'react';

const FailureView = ({ onRetry }) => {
  return (
    <div className="failure-view">
      <h3>Failed to load lists</h3>
      <button onClick={onRetry}>Try Again</button>
    </div>
  );
};

export default FailureView;
