//import './App.css';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import CssBaseline from '@mui/material/CssBaseline';
import LoginPage from './pages/Login/Login';
import RegisterPage from './pages/Register/Register';
import HomePage from './pages/Home/Home';
import DestinationPage from './pages/Destination/DestinationPage';
import Payment from './pages/Payment/Payment';
import HotelPage from './pages/Hotel/HotelPage';
import Reservation from './pages/Reservation/ReservationPage';
import TravelerAccountPage from './pages/Account/TravelerAccountPage';

function App() {
  return (
    <>
      <CssBaseline />
      <div className="App">
        <BrowserRouter>
          <Routes>
            <Route path="/signIn" element={<LoginPage />} />
            <Route path="/register" element={<RegisterPage />} />
            <Route path="/" element={<HomePage />} />
            <Route path="/destination/:destinationName" element={<DestinationPage />} />
            <Route path="/payment" element={<Payment />} />
            <Route path="/hotel/:hotelName" element={<HotelPage />} />
            <Route path="/reservation/:packageName" element={<Reservation />} />
            <Route path="/account/traveler" element={<TravelerAccountPage />} />
          </Routes>
        </BrowserRouter>
      </div>
    </>
  );
}

export default App;
