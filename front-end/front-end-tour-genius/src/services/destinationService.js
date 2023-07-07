import axios from 'axios';

export const addDestination = async (destinationData) => {
  try {
    const response = await axios.post('http://localhost:9008/api/destinations', destinationData);
    return response.data;
  } catch (error) {
    console.error('Error adding destination:', error);
    throw error;
  }
};
