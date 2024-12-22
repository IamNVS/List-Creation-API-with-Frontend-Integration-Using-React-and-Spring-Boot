import React, { useState, useEffect } from "react";
import { fetchLists } from "./api";
import ListContainer from "./components/ListContainer";
import Loader from "./components/Loader";
import FailureView from "./components/FailureView";
import "./styles/App.css";

const App = () => {
  const [lists, setLists] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(false);
  const [selectedLists, setSelectedLists] = useState([]);

  useEffect(() => {
    const loadLists = async () => {
      try {
        const fetchedLists = await fetchLists();
        setLists(fetchedLists);
        setLoading(false);
      } catch (error) {
        setError(true);
        setLoading(false);
      }
    };

    loadLists();
  }, []);

  const handleRetry = () => {
    setError(false);
    setLoading(true);
    setLists([]);
    fetchLists();
  };

  const handleListSelect = (listId) => {
    if (selectedLists.includes(listId)) {
      setSelectedLists(selectedLists.filter(id => id !== listId));
    } else {
      setSelectedLists([...selectedLists, listId]);
    }
  };

  const handleMoveItem = (item, fromList, toList) => {
    // Implement logic to move item between lists
  };

  const handleCreateNewList = () => {
    if (selectedLists.length !== 2) {
      alert("You should select exactly 2 lists to create a new list");
      return;
    }

    // Logic for creating a new list and moving items
  };

  if (loading) {
    return <Loader />;
  }

  if (error) {
    return <FailureView onRetry={handleRetry} />;
  }

  return (
    <div className="App">
      <h1>List Creation App</h1>
      <div className="list-containers">
        {lists.map((list) => (
          <ListContainer
            key={list.id}
            list={list}
            onMoveLeft={(item) => handleMoveItem(item, list, "newList")}
            onMoveRight={(item) => handleMoveItem(item, list, "newList")}
          />
        ))}
      </div>
      <div className="actions">
        <button onClick={handleCreateNewList}>Create a new list</button>
      </div>
    </div>
  );
};

export default App;
