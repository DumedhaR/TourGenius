import React, { useState } from 'react';
import '../../utils/destinationDashboard.css';

function DestinationDashboard() {
  const [destination, setDestination] = useState({
    name: '',
    image: '',
    rating: '',
    country: '',
    description: ''
  });

  const handleChange = (e) => {
    const { name, value, type } = e.target;
    const updatedValue = type === 'file' ? e.target.files[0] : value;
    setDestination((prevState) => ({ ...prevState, [name]: updatedValue }));
  };

  const handleSubmit = (e) => {
    e.preventDefault();

    //send destination data to back-end

    setDestination({
      name: '',
      image: '',
      rating: '',
      country: '',
      description: ''
    });
  };

  return (
    <div className="dashboard-container">
      <h2 className="dashboard-title">Destination Dashboard</h2>
      <form onSubmit={handleSubmit}>
        <div className="form-group">
          <label>Name:</label>
          <input type="text" name="name" value={destination.name} onChange={handleChange} />
        </div>
        <div className="form-group">
          <label>Image:</label>
          <input type="file" accept="image/*" name="image" onChange={handleChange} />
        </div>
        <div className="form-group">
          <label>Rating:</label>
          <div className="rating-group">
            {/* Create radio buttons for rating */}
            <label>
              <input
                type="radio"
                name="rating"
                value="1"
                checked={destination.rating === '1'}
                onChange={handleChange}
              />
              <span className="star">&#9733;</span>
            </label>
            <label>
              <input
                type="radio"
                name="rating"
                value="2"
                checked={destination.rating === '2'}
                onChange={handleChange}
              />
              <span className="star">&#9733;</span>
            </label>
            <label>
              <input
                type="radio"
                name="rating"
                value="3"
                checked={destination.rating === '3'}
                onChange={handleChange}
              />
              <span className="star">&#9733;</span>
            </label>
            <label>
              <input
                type="radio"
                name="rating"
                value="4"
                checked={destination.rating === '4'}
                onChange={handleChange}
              />
              <span className="star">&#9733;</span>
            </label>
            <label>
              <input
                type="radio"
                name="rating"
                value="5"
                checked={destination.rating === '5'}
                onChange={handleChange}
              />
              <span className="star">&#9733;</span>
            </label>
          </div>
        </div>
        <div className="form-group">
          <label>Country:</label>
          <input type="text" name="country" value={destination.country} onChange={handleChange} />
        </div>
        <div className="form-group">
          <label>Description:</label>
          <textarea name="description" value={destination.description} onChange={handleChange} />
        </div>
        <button type="submit">Add Destination</button>
      </form>
    </div>
  );
}

export default DestinationDashboard;
