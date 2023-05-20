import React from 'react';
import '../../utils/location.css';

function GoogleLocation({ location }) {
  return (
    <div className="mapContainer">
      <iframe
        src={location}
        width="100%"
        height="100%"
        style={{ border: '0' }}
        allowFullScreen=""
        loading="lazy"
      />
    </div>
  );
}

export default GoogleLocation;
