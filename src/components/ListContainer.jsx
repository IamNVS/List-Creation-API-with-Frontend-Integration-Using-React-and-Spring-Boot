import React from 'react';
import ListItem from './ListItem';

const ListContainer = ({ list, onMoveLeft, onMoveRight }) => {
  return (
    <div className="list-container">
      <h2>List {list.listNumber}</h2>
      {list.items && list.items.map((item) => (
        <ListItem
          key={item.id}
          item={item}
          onMoveLeft={onMoveLeft}
          onMoveRight={onMoveRight}
        />
      ))}
    </div>
  );
};

export default ListContainer;
