import * as React from 'react';
import Box from '@mui/material/Box';
import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';
import Typography from '@mui/material/Typography';
import '../../utils/BookingCard.css';
import { createTheme, ThemeProvider } from '@mui/material/styles';

export default function BookingCard({
  checkInDate,
  checkOutDate,
  payment,
  totalRooms,
  packageName,
  clientName
}) {
  const theme = createTheme({
    palette: {
      green: '#4DA343',
      yellow: '#ffcc00'
    }
  });

  return (
    <Box sx={{ minWidth: 300 }}>
      <Card variant="outlined">
        <CardContent>
          <ThemeProvider theme={theme}>
            <div className="card-raw">
              <Typography sx={{ fontSize: 13 }} color="text.secondary" gutterBottom>
                Room Booking
              </Typography>
              <Typography variant="h6" component="div">
                {clientName}
              </Typography>
              <Typography color="green">{packageName}</Typography>
              <Typography color="yellow">{totalRooms} rooms</Typography>
            </div>
            <div className="duration">
              <div id="checkin">
                <Typography variant="h7" component="div">
                  Check-in
                </Typography>
                <Typography color="text.secondary">{checkInDate}</Typography>
              </div>
              <div id="checkout">
                <Typography variant="h7" component="div">
                  Check-out
                </Typography>
                <Typography color="text.secondary">{checkOutDate}</Typography>
              </div>
            </div>
            <div className="card-raw">
              <Typography variant="h7" component="div">
                Payment
              </Typography>
              <Typography color="text.secondary">{payment} $</Typography>
            </div>
          </ThemeProvider>
        </CardContent>
      </Card>
    </Box>
  );
}
