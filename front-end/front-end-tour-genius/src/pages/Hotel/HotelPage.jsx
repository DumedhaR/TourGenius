import React from 'react';
import NavigationBar from '../../components/Navigation/NavigationBar';
import '../../utils/hotelPage.css';
// this YalaHotelData file is removed when components are intergrated
import { YalaHotelData } from './yalaHotelData';
import Typography from '@mui/material/Typography';
import Rating from '@mui/material/Rating';
import { PackageData } from '../../components/HotelPackages/packageData';
import PackagesCard from '../../components/HotelPackages/HotelPackegesCard';
import { DemoContainer } from '@mui/x-date-pickers/internals/demo';
import { AdapterDayjs } from '@mui/x-date-pickers/AdapterDayjs';
import { LocalizationProvider } from '@mui/x-date-pickers/LocalizationProvider';
import { DatePicker } from '@mui/x-date-pickers/DatePicker';
import TextField from '@mui/material/TextField';
import Button from '@mui/material/Button';
import { useFormik } from 'formik';
import * as Yup from 'yup';
import UserReviews from '../../components/Reviews/ReviewFeedbacks';
import GoogleLocation from '../../components/Location/Location';
import Footer from '../../components/Footer/Footer';

function HotelPage() {
  const validationSchema = Yup.object().shape({
    checkInDate: Yup.date().required('Check-In date is required'),
    checkOutDate: Yup.date()
      .required('Check-Out date is required')
      .min(Yup.ref('checkInDate'), 'Check-Out date must be after Check-In date'),
    adults: Yup.number()
      .typeError('Please enter number')
      .required('Number of adults is required')
      .min(1, 'Number of adults must be at least 1')
  });

  const formik = useFormik({
    initialValues: {
      checkInDate: '',
      checkOutDate: '',
      adults: ''
    },
    validationSchema,
    onSubmit: (values) => {
      console.log(values);
    }
  });
  return (
    <div className="hotelPage">
      <div className="hotelNavigation">
        <NavigationBar />
      </div>
      <div
        className="hotelHeader"
        style={{
          backgroundImage: `url(${YalaHotelData[0].hotelImage})`,
          width: '100%',
          height: '90vh',
          backgroundSize: '100% 100%',
          backgroundRepeat: 'no-reapeat',
          position: 'relative',
          border: '1px solid black'
        }}>
        <div className="hotelContent">
          <Typography variant="h4" gutterBottom>
            {YalaHotelData[0].hotelName}
          </Typography>
          <div className="hotelContryRating">
            <Typography sx={{ color: 'green' }} variant="subtitle1" gutterBottom>
              {YalaHotelData[0].hotelCountry}
            </Typography>
            <Rating
              sx={{ marginLeft: '5px' }}
              name="read-only"
              value={YalaHotelData[0].hotelRating}
              readOnly
            />
          </div>
          <Typography sx={{ marginTop: '20px' }} variant="body2" gutterBottom>
            {YalaHotelData[0].hotelDescription}
          </Typography>
        </div>
      </div>
      <div className="hotelRooms">
        <Typography variant="h5" gutterBottom>
          Packages at {YalaHotelData[0].hotelName}
        </Typography>
        <form onSubmit={formik.handleSubmit}>
          <div className="checkInCheckOutBar">
            <div className="checkInPicker">
              <LocalizationProvider dateAdapter={AdapterDayjs}>
                <DemoContainer components={['DatePicker']}>
                  <DatePicker
                    label="Check-In"
                    disablePast
                    name="checkInDate"
                    value={formik.values.checkInDate}
                    onChange={(date) => formik.setFieldValue('checkInDate', date)}
                    error={formik.touched.checkInDate && Boolean(formik.errors.checkInDate)}
                    helperText={formik.touched.checkInDate && formik.errors.checkInDate}
                  />
                </DemoContainer>
              </LocalizationProvider>
            </div>
            <div className="checkOutPicker">
              <LocalizationProvider dateAdapter={AdapterDayjs}>
                <DemoContainer components={['DatePicker']}>
                  <DatePicker
                    label="Check-Out"
                    disablePast
                    name="checkOutDate"
                    value={formik.values.checkOutDate}
                    onChange={(date) => formik.setFieldValue('checkOutDate', date)}
                    error={formik.touched.checkOutDate && Boolean(formik.errors.checkOutDate)}
                    helperText={formik.touched.checkOutDate && formik.errors.checkOutDate}
                  />
                </DemoContainer>
              </LocalizationProvider>
            </div>
            <div className="selectAdults">
              <TextField
                sx={{ marginTop: '8px' }}
                label="Adults"
                variant="outlined"
                name="adults"
                value={formik.values.adults}
                onChange={formik.handleChange}
                onBlur={formik.handleBlur}
                error={formik.touched.adults && Boolean(formik.errors.adults)}
                helperText={formik.touched.adults && formik.errors.adults}
              />
            </div>
            <div>
              <Button
                sx={{
                  width: '150px',
                  height: '55px',
                  backgroundColor: 'green',
                  marginTop: '8px',
                  '&:hover': {
                    backgroundColor: '#00cc00'
                  },
                  textTransform: 'none'
                }}
                variant="contained"
                size="large"
                type="submit">
                Search
              </Button>
            </div>
          </div>
        </form>
        <div>
          {PackageData.map((item, index) => (
            <div className="availablePackages" key={`package-${index}`}>
              <PackagesCard
                packageName={item.packageName}
                packageImage={item.packageImage}
                packageRating={item.packageRating}
                packageDescription={item.packageDescription}
                packageInclude={item.packageInclude}
                availableRooms={item.availableRooms}
                packagePrize={item.packagePrize}
              />
            </div>
          ))}
        </div>
      </div>
      <div className="hotelFeedbackMapContainer">
        <div className="hotelFeedbacks">
          <Typography variant="h5" gutterBottom>
            Traveler Feedbacks
          </Typography>
          <Typography sx={{ lineHeight: '0' }} variant="caption" display="block" gutterBottom>
            Send us your thought about {YalaHotelData[0].hotelName}.
          </Typography>
          <div className="hotelReviews">
            <UserReviews />
          </div>
        </div>
        <div className="hotelMap">
          <Typography variant="h5" gutterBottom>
            View In Map
          </Typography>
          <Typography sx={{ lineHeight: '0' }} variant="caption" display="block" gutterBottom>
            You can find the hotels, other travel locations around your base destination.
          </Typography>
          <div className="displayHotelLocation">
            <GoogleLocation location={YalaHotelData[0].hotelLocation} />
          </div>
        </div>
      </div>
      <div className="hotelFooter" style={{ backgroundColor: '#00cc00' }}>
        <Footer />
      </div>
    </div>
  );
}

export default HotelPage;
