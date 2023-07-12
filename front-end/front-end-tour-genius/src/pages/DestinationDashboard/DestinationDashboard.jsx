import React, { useState } from 'react';
import '../../utils/destinationDashboard.css';
import { FormControl, Button } from '@mui/material';

function DestinationDashboard() {
  const [destinations, setDestinations] = useState([]);
  const [newDestination, setNewDestination] = useState({
    name: '',
    image: '',
    rating: '',
    description: ''
  });
  const [editingIndex, setEditingIndex] = useState(-1);

  const handleChange = (e) => {
    const { name, value, type } = e.target;
    let updatedValue = type === 'file' ? e.target.files[0].name : value;

    if (name === 'rating') {
      updatedValue = Math.min(Math.max(parseInt(updatedValue), 1), 5);
    }

    setNewDestination((prevState) => ({ ...prevState, [name]: updatedValue }));
  };

  const handleAddDestination = () => {
    setDestinations((prevDestinations) => [...prevDestinations, newDestination]);
    setNewDestination({
      name: '',
      image: '',
      rating: '',
      description: ''
    });
  };

  const handleEditDestination = (index) => {
    setEditingIndex(index);
    const editedDestination = destinations[index];
    setNewDestination(editedDestination);
  };

  const handleUpdateDestination = () => {
    setDestinations((prevDestinations) => {
      const updatedDestinations = [...prevDestinations];
      updatedDestinations[editingIndex] = newDestination;
      return updatedDestinations;
    });
    setEditingIndex(-1);
    setNewDestination({
      name: '',
      image: '',
      rating: '',
      description: ''
    });
  };

  const handleDeleteDestination = (index) => {
    setDestinations((prevDestinations) => prevDestinations.filter((_, i) => i !== index));
  };

  const isEditing = editingIndex !== -1;

  return (
    <div className="destinationDashboard">
      <div className="backgroundDashboard">
        <div className="formContent">Destination Dashboard</div>
        <div className="destinationForm">
          <FormControl>
            <input
              className="destinationRecord"
              type="text"
              name="name"
              value={newDestination.name}
              onChange={handleChange}
              placeholder="Name"
              required
            />
            <input
              className="destinationRecord"
              type="file"
              name="image"
              onChange={handleChange}
              placeholder="Image"
              required
            />
            <input
              className="destinationRecord"
              type="number"
              name="rating"
              value={newDestination.rating}
              onChange={handleChange}
              placeholder="Rating (1-5)"
              min="1"
              max="5"
              required
            />
            <input
              className="destinationRecord"
              type="text"
              name="description"
              value={newDestination.description}
              onChange={handleChange}
              placeholder="Description"
              required
            />
            {isEditing ? (
              <Button
                className="desUpdateButton"
                variant="contained"
                onClick={handleUpdateDestination}>
                Update
              </Button>
            ) : (
              <Button
                className="desAddButton"
                variant="contained"
                onClick={handleAddDestination}
                disabled={
                  !newDestination.name ||
                  !newDestination.image ||
                  !newDestination.rating ||
                  !newDestination.description
                }>
                Add
              </Button>
            )}
          </FormControl>
        </div>
        <div className="destinationTable">
          <table>
            <thead>
              <tr>
                <th>Name</th>
                <th>Image</th>
                <th>Rating</th>
                <th>Description</th>
                <th>Actions</th>
              </tr>
            </thead>
            <tbody>
              {destinations.map((destination, index) => (
                <tr key={index}>
                  <td>{destination.name}</td>
                  <td>{destination.image}</td>
                  <td>{destination.rating}</td>
                  <td>{destination.description}</td>
                  <td className="actionButtons">
                    <Button
                      className="desEditButton"
                      variant="contained"
                      onClick={() => handleEditDestination(index)}>
                      Edit
                    </Button>
                    <Button
                      variant="contained"
                      className="desDeleteButton"
                      onClick={() => handleDeleteDestination(index)}>
                      Delete
                    </Button>
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      </div>
    </div>
  );
}

export default DestinationDashboard;
