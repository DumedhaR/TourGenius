import React from 'react';
import '../../utils/introduceDestination.css';
import Rating from '@mui/material/Rating';
import Typography from '@mui/material/Typography';

function DestinationIntro({
  destinationName,
  destinationCountry,
  destinationRating,
  destinationDescription,
  destinationImage,
  destinationContent
}) {
  const desNameInDescription = `About ${destinationName}`;
  return (
    <div className="desIntro ">
      <div className="desTopicSummary">
        <div className="desSummary">
          <h1 id="desName">{destinationName}</h1>
          <div className="desCountryRating">
            <p id="desCountry">{destinationCountry}</p>
            <Rating
              sx={{ marginLeft: '10px', marginTop: '8px' }}
              value={destinationRating}
              readOnly
            />
          </div>
          <Typography sx={{ padding: '30px 50px 30px 30px' }} variant="body1" gutterBottom>
            {destinationDescription}
          </Typography>
        </div>
        <div className="desImageContainer">
          <img id="desImage" src={destinationImage} width="100%" height="100%" />
        </div>
      </div>
      <div className="desDescriptionContainer">
        <h2 id="desNameInDescription">{desNameInDescription}</h2>
        <div className="desDescription">{destinationContent}</div>
      </div>
    </div>
  );
}

export default DestinationIntro;
