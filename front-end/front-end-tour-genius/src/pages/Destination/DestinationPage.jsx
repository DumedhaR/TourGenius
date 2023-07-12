import React from 'react';
import NavigationBar from '../../components/Navigation/NavigationBar';
import '../../utils/destinationPage.css';
// This DataFiles are removed when components are intergrated
import { YalaData, yalaImageData } from './yalaDestinationData';
import { NearDestinationData } from './nearDestinationData';
import DestinationIntro from '../../components/Destination/IntroduceDestination';
import ImageContainer from '../../components/ImageList/ImageList';
import Footer from '../../components/Footer/Footer';
import UserReviews from '../../components/Reviews/ReviewFeedbacks';
import GoogleLocation from '../../components/Location/Location';
import NearSimilarPlacesContainer from '../../components/Destination/NearSimilarDestination';
import { useRef, useEffect } from 'react';
import HotelContainer from '../../components/Hotel/HotelContainer';
import { HotelData } from '../../components/Hotel/hotelData';
import Button from '@mui/material/Button';
import Box from '@mui/material/Box';
import ButtonGroup from '@mui/material/ButtonGroup';

function DestinationPage() {
  const nearSimilarDestinationRef = useRef(null);
  const mapRef = useRef(null);
  const nearHotelContainerRef = useRef(null);

  useEffect(() => {
    window.scrollTo(0, 0);
  }, []);

  const scrollToNearSimilarDestination = () => {
    if (nearSimilarDestinationRef.current) {
      nearSimilarDestinationRef.current.scrollIntoView({ behavior: 'smooth' });
    }
  };
  const scrollToMap = () => {
    if (mapRef.current) {
      mapRef.current.scrollIntoView({ behavior: 'smooth' });
    }
  };
  const scrollToNearHotelContainer = () => {
    if (nearHotelContainerRef.current) {
      nearHotelContainerRef.current.scrollIntoView({ behavior: 'smooth' });
    }
  };

  const scrollButtons = [
    <Button key="1-desScroll" onClick={scrollToNearSimilarDestination}>
      Near by Places
    </Button>,
    <Button key="2-desScroll" onClick={scrollToNearSimilarDestination}>
      Similar Places
    </Button>,
    <Button key="3-desScroll" onClick={scrollToMap}>
      View in Map
    </Button>,
    <Button key="4-desScroll" onClick={scrollToNearHotelContainer}>
      Where to Stay
    </Button>
  ];
  return (
    <div className="destinationPage">
      <div className="deNavigation">
        <NavigationBar />
      </div>
      <div className="desIntroduction">
        <DestinationIntro
          destinationName={YalaData[0].destinationName}
          destinationCountry={YalaData[0].destinationCountry}
          destinationRating={YalaData[0].destinationRating}
          destinationDescription={YalaData[0].destinationDescription}
          destinationImage={YalaData[0].destinationImage}
          destinationContent={YalaData[0].destinationContent}
        />
      </div>
      <div className="scrollButtonGroup">
        <Box
          sx={{
            display: 'flex',
            flexDirection: 'column',
            alignItems: 'center',
            '& > *': {
              m: 1
            }
          }}>
          <ButtonGroup size="large" color="success" aria-label="large button group">
            {scrollButtons}
          </ButtonGroup>
        </Box>
      </div>
      <div className="desImageGallery">
        <h2 id="desGalleryTopic">Explore Our Photo Collection</h2>
        <div className="desImageList">
          <ImageContainer imageData={yalaImageData} />
        </div>
      </div>
      <div className="desNearSimilarDestination">
        <div className="desNearDestination" ref={nearSimilarDestinationRef}>
          <NearSimilarPlacesContainer
            desPlaceTopic="Nearby places"
            destinationData={NearDestinationData}
          />
        </div>
        <div className="desSimilarDestination">
          <NearSimilarPlacesContainer
            desPlaceTopic="Similar places"
            destinationData={NearDestinationData}
          />
        </div>
      </div>

      <div className="desReviewsMap">
        <div className="desReviews">
          <h2 id="desReviewTopic">Traveler Feedbacks</h2>
          <p id="desReviewsDescription">Send us your thought about Yala National Park.</p>
          <div className="desReviewContainer">
            <UserReviews />
          </div>
        </div>
        <div className="desMap" ref={mapRef}>
          <h2 id="desMapTopic">View In Map</h2>
          <p id="desMapDescription">
            You can find the hotels, other travel locations around your base destination.
          </p>
          <div className="desMapContainer">
            <GoogleLocation location={YalaData[0].destinationLocation} />
          </div>
        </div>
      </div>
      <div className="desNearHotelContainer" ref={nearHotelContainerRef}>
        <HotelContainer
          topic="Where To Stay"
          description="Explore best nearby hotels and apartments."
          hotelData={HotelData}
        />
      </div>
      <div className="footerInDesPage">
        <Footer />
      </div>
    </div>
  );
}

export default DestinationPage;
