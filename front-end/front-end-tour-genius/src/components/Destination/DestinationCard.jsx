import React from 'react';
import Card from '@mui/material/Card';
import CardActions from '@mui/material/CardActions';
import CardContent from '@mui/material/CardContent';
import CardMedia from '@mui/material/CardMedia';
import Button from '@mui/material/Button';
import Typography from '@mui/material/Typography';
import { useState } from 'react';

function DestinationCard({ data }) {
  const [showMore, setShowMore] = useState(false);
  return (
    <div>
      {data.map((element, index) => (
        <div className="card" key={`desCard-${index}`}>
          <Card sx={{ maxWidth: 345 }}>
            <CardMedia
              component="img"
              alt={element.destinationName}
              height="200px"
              image={element.destinationImage}
            />
            <CardContent>
              <Typography gutterBottom variant="h5" component="div">
                {element.destinationName}
              </Typography>
              <Typography gutterBottom variant="h7" component="div">
                Situated in {element.destinationCountry}
              </Typography>
              <Typography variant="body2" color="text.secondary">
                {showMore
                  ? element.destinationDescription
                  : element.destinationDescription &&
                    element.destinationDescription.substring(0, 100)}
              </Typography>
            </CardContent>
            {element.destinationDescription.length >= 100 && (
              <CardActions>
                <Button size="small" onClick={() => setShowMore(!showMore)}>
                  {!showMore ? 'show more' : 'show less'}
                </Button>
              </CardActions>
            )}
          </Card>
        </div>
      ))}
    </div>
  );
}

export default DestinationCard;
