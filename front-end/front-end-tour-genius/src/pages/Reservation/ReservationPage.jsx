// This page is completed during the merge of the FE and BE integaration
import React from 'react';
import '../../utils/reservationPage.css';
import Typography from '@mui/material/Typography';
import Footer from '../../components/Footer/Footer';

function Reservation() {
  return (
    <div>
      <div className="reservationHeader">
        <Typography
          sx={{ color: 'white', textAlign: 'center', marginTop: '50px' }}
          variant="h4"
          gutterBottom>
          Finalize Your Reservation
          <br />
          Here!
        </Typography>
      </div>
      <div className="reservationContainer">
        <div className="reservationDetails">
          <div className="bookingDetails">
            <Typography variant="h5" gutterBottom>
              Booking Details
            </Typography>
            <Typography variant="subtitle2" gutterBottom>
              You selected
            </Typography>
          </div>
          <div className="guestDetails"></div>
        </div>
      </div>
      <div className="reservationFooter">
        <Footer />
      </div>
    </div>
  );
}

export default Reservation;
