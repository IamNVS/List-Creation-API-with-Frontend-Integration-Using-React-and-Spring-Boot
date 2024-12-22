import React from 'react';

const ListItem = ({ item, onMoveLeft, onMoveRight }) => {
  return (
    <div className="list-item">
      <span>{item.itemName}</span>
      <div>
        {onMoveLeft && <button onClick={() => onMoveLeft(item)}>←</button>}
        {onMoveRight && <button onClick={() => onMoveRight(item)}>→</button>}
      </div>
    </div>
  );
};

export default ListItem;
