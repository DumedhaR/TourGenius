import React from 'react';
import NavigationBar from '../../components/Navigation/NavigationBar';
import Footer from '../../components/Footer/Footer';
import Reservation from '../../components/Reservation/Reservation';
import { ReservationData } from './ReservationData';

function ReservationPage() {
  return (
    <div className="reservationPage">
      <div className="reserNavigation">
        <NavigationBar />
      </div>
      <div className="reserBody">
        <Reservation
          packageName={ReservationData.packageName}
          adults={ReservationData.adults}
          checkIn={ReservationData.checkIn}
          checkOut={ReservationData.checkOut}
          perNight={ReservationData.perNight}
          roomsLeft={ReservationData.roomsLeft}
        />
      </div>
      <div className="reservationFooter">
        <Footer />
      </div>
    </div>
  );
}
export default ReservationPage;
