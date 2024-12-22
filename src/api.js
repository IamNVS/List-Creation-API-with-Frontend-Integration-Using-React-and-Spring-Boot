import axios from "axios";

const API_BASE_URL = "http://localhost:3306/Assignment/lists";

// Fetch all list containers from the backend
export const fetchLists = async () => {
  try {
    const response = await axios.get(API_BASE_URL);
    return response.data; // return the list data
  } catch (error) {
    throw error; // throw error if the request fails
  }
};
