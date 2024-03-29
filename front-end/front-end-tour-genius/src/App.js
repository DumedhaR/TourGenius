//import './App.css';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import CssBaseline from '@mui/material/CssBaseline';
import LoginPage from './pages/Login/Login';
import RegisterPage from './pages/Register/Register';
import HomePage from './pages/Home/Home';
import DestinationPage from './pages/Destination/DestinationPage';
import DestinationDashboard from './pages/DestinationDashboard/DestinationDashboard';
import Payment from './pages/Payment/Payment';
import HotelPage from './pages/Hotel/HotelPage';
import TravelerAccountPage from './pages/TravelerAccount/TravelerAccountPage';
import ClientAccountPage from './pages/ClientAccount/ClientAccountPage';
import ReservationPage from './pages/Reservation/ReservationPage';
import { useEffect } from 'react';
import { useDispatch } from 'react-redux';
import { getLogedUserAction } from './redux/user/userSlice';

function App() {
  const dispatch = useDispatch();

  useEffect(() => {
    dispatch(getLogedUserAction());
  }, []);
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
            <Route path="/destination/dashboard" element={<DestinationDashboard />} />
            <Route path="/payment" element={<Payment />} />
            <Route path="/hotel/:hotelName" element={<HotelPage />} />
            <Route path="/reservation/:packageName" element={<ReservationPage />} />
            <Route path="/account/traveler" element={<TravelerAccountPage />} />
            <Route path="/account/client" element={<ClientAccountPage />} />
          </Routes>
        </BrowserRouter>
      </div>
    </>
  );
}

export default App;
