// This page is completed during the merge of the FE and BE integaration
import React from 'react';
import '../../utils/reservation.css';
import Typography from '@mui/material/Typography';
import Box from '@mui/material/Box';
import Grid from '@mui/material/Unstable_Grid2';
import Button from '@mui/material/Button';
import { createTheme, ThemeProvider } from '@mui/material/styles';
import TextField from '@mui/material/TextField';
import { useState } from 'react';
import MenuItem from '@mui/material/MenuItem';

const theme = createTheme({
  palette: {
    primary: {
      main: '#4DA343',
      darker: '#4DA343',
      contrastText: '#FFFFFF'
    },
    secondary: {
      main: '#11cb5f'
    }
  }
});

const total = [
  {
    value: '0',
    label: '0'
  },
  {
    value: '1',
    label: '1'
  },
  {
    value: '2',
    label: '2'
  }
];

function findTotalDays(checkIn, checkOut) {
  const startDate = new Date(checkIn);
  const endDate = new Date(checkOut);

  const timeDifference = Math.abs(endDate.getTime() - startDate.getTime());
  const durationInDays = Math.ceil(timeDifference / (1000 * 3600 * 24));
  return durationInDays;
}

function calculatePrice(perNight, totalNights, totalRooms) {
  const price = perNight * totalNights * totalRooms;
  return price;
}

function buildTextBoxList(len) {
  const list = [];
  for (let i = 1; i <= len; i++) {
    list.push({ value: i, label: i.toString() });
  }
  return list;
}

function Reservation({ packageName, adults, checkIn, checkOut, roomsLeft, perNight }) {
  const [selectedRooms, setSelectedRooms] = useState(1);
  const totRooms = buildTextBoxList(roomsLeft);
  const totAdult = buildTextBoxList(adults);
  const totalNights = findTotalDays(checkIn, checkOut);

  const handleRoomChange = (event) => {
    setSelectedRooms(parseInt(event.target.value));
  };

  return (
    <div>
      <div className="reservationHeader">
        <Typography
          sx={{ color: 'white', textAlign: 'center', marginTop: '80px' }}
          variant="h4"
          gutterBottom>
          Finalize Your Reservation
          <br />
          Here!
        </Typography>
      </div>

      <div className="reservationContainer">
        <div className="reservationDetails">
          <Box sx={{ flexGrow: 1 }}>
            <Grid container spacing={3}>
              <Grid xs={6}>
                <div className="booking">
                  <Grid xs={12}>
                    <Typography variant="h5" gutterBottom>
                      Booking Details
                    </Typography>
                  </Grid>
                  <Grid xs={12}>
                    <Typography variant="h6" gutterBottom>
                      You selected
                    </Typography>
                    <Typography color="text.secondary" sx={{ mb: 1 }}>
                      {packageName}
                    </Typography>
                    <div>
                      <Grid container spacing={0} p={0}>
                        <Grid xs={4}>
                          <Typography color="text.secondary">
                            Total rooms
                            <Box
                              component="form"
                              sx={{
                                '& .MuiTextField-root': { mt: 1, width: '10ch' }
                              }}
                              noValidate
                              autoComplete="off">
                              <div>
                                <TextField
                                  id="totalRooms"
                                  select
                                  defaultValue={1}
                                  size="small"
                                  InputProps={{
                                    style: {
                                      borderRadius: '20px',
                                      backgroundColor: 'white'
                                    }
                                  }}
                                  onChange={handleRoomChange}>
                                  {totRooms.map((option) => (
                                    <MenuItem key={option.value} value={option.value}>
                                      {option.label}
                                    </MenuItem>
                                  ))}
                                </TextField>
                              </div>
                            </Box>
                          </Typography>
                        </Grid>
                        <Grid xs={4}>
                          <Typography color="text.secondary">
                            Adults
                            <Box
                              component="form"
                              sx={{
                                '& .MuiTextField-root': { mt: 1, width: '10ch' }
                              }}
                              noValidate
                              autoComplete="off">
                              <div>
                                <TextField
                                  id="totalAdults"
                                  select
                                  defaultValue={adults}
                                  size="small"
                                  InputProps={{
                                    readOnly: true,
                                    style: {
                                      borderRadius: '20px',
                                      backgroundColor: 'white'
                                    }
                                  }}
                                  onChange={handleRoomChange}>
                                  {totAdult.map((option) => (
                                    <MenuItem key={option.value} value={option.value}>
                                      {option.label}
                                    </MenuItem>
                                  ))}
                                </TextField>
                              </div>
                            </Box>
                          </Typography>
                        </Grid>
                        <Grid xs={4}>
                          <Typography color="text.secondary">
                            Childs
                            <Box
                              component="form"
                              sx={{
                                '& .MuiTextField-root': { mt: 1, width: '10ch' }
                              }}
                              noValidate
                              autoComplete="off">
                              <div>
                                <TextField
                                  id="totalChilds"
                                  select
                                  defaultValue={0}
                                  size="small"
                                  InputProps={{
                                    style: {
                                      borderRadius: '20px',
                                      backgroundColor: 'white'
                                    }
                                  }}
                                  onChange={handleRoomChange}>
                                  {total.map((option) => (
                                    <MenuItem key={option.value} value={option.value}>
                                      {option.label}
                                    </MenuItem>
                                  ))}
                                </TextField>
                              </div>
                            </Box>
                          </Typography>
                        </Grid>
                      </Grid>
                    </div>
                  </Grid>
                  <Grid xs={12}>
                    <div>
                      <Grid container spacing={0} p={0}>
                        <Grid xs={4}>
                          <div id="checkin">
                            <Typography variant="h6" component="div">
                              Check-in
                            </Typography>
                            <Typography color="text.secondary">{checkIn}</Typography>
                          </div>
                        </Grid>
                        <Grid xs={8}>
                          <div id="checkout">
                            <Typography variant="h6" component="div">
                              Check-out
                            </Typography>
                            <Typography color="text.secondary">{checkOut}</Typography>
                          </div>
                        </Grid>
                      </Grid>
                    </div>
                  </Grid>
                  <Grid xs={12}>
                    <Typography variant="h6" gutterBottom>
                      Total nights
                    </Typography>
                    <Typography color="text.secondary">{totalNights} nights</Typography>
                  </Grid>
                  <Grid xs={12}>
                    <Typography variant="h6" gutterBottom>
                      Your price summery
                    </Typography>
                    <Typography color="text.secondary">
                      Original price {calculatePrice(perNight, totalNights, selectedRooms)}$
                    </Typography>
                    <Typography color="text.secondary">Discount 0$</Typography>
                  </Grid>
                  <Grid xs={12}>
                    <Typography variant="h6" gutterBottom>
                      Final price
                    </Typography>
                    <Typography color="text.secondary">
                      {calculatePrice(perNight, totalNights, selectedRooms)} $
                    </Typography>
                  </Grid>
                </div>
              </Grid>
              <Grid xs={6}>
                <div className="guest">
                  <Grid xs={12}>
                    <Typography variant="h5" gutterBottom>
                      Enter Guest Details
                    </Typography>
                  </Grid>
                  <Grid xs={12}>
                    <Typography variant="h6" gutterBottom>
                      First name
                    </Typography>
                    <Box
                      component="form"
                      sx={{
                        '& > :not(style)': { width: '70%' }
                      }}
                      noValidate
                      autoComplete="off">
                      <TextField
                        id="outlined-basic"
                        label="first name"
                        variant="outlined"
                        size="small"
                        InputProps={{
                          style: {
                            borderRadius: '20px',
                            backgroundColor: 'white'
                          }
                        }}
                        required
                      />
                    </Box>
                  </Grid>
                  <Grid xs={12}>
                    <Typography variant="h6" gutterBottom>
                      Last name
                    </Typography>
                    <Box
                      component="form"
                      sx={{
                        '& > :not(style)': { width: '70%' }
                      }}
                      noValidate
                      autoComplete="off">
                      <TextField
                        id="outlined-basic"
                        label="last name"
                        variant="outlined"
                        size="small"
                        InputProps={{
                          style: {
                            borderRadius: '20px',
                            backgroundColor: 'white'
                          }
                        }}
                        required
                      />
                    </Box>
                  </Grid>
                  <Grid xs={12}>
                    <Typography variant="h6" gutterBottom>
                      Email address
                    </Typography>
                    <Box
                      component="form"
                      sx={{
                        '& > :not(style)': { width: '70%' }
                      }}
                      noValidate
                      autoComplete="off">
                      <TextField
                        id="outlined-basic"
                        label="email"
                        variant="outlined"
                        size="small"
                        InputProps={{
                          style: {
                            borderRadius: '20px',
                            backgroundColor: 'white'
                          }
                        }}
                        required
                      />
                    </Box>
                  </Grid>
                  <Grid xs={12}>
                    <Typography variant="h6" gutterBottom>
                      Contact number
                    </Typography>
                    <Box
                      component="form"
                      sx={{
                        '& > :not(style)': { width: '70%' }
                      }}
                      noValidate
                      autoComplete="off">
                      <TextField
                        id="outlined-basic"
                        label="contact"
                        variant="outlined"
                        size="small"
                        InputProps={{
                          style: {
                            borderRadius: '20px',
                            backgroundColor: 'white'
                          }
                        }}
                        required
                      />
                    </Box>
                  </Grid>
                  <Grid xs={12}>
                    <div className="raw">
                      <div className="city">
                        <Typography variant="h6" gutterBottom>
                          City
                        </Typography>
                        <Box
                          component="form"
                          sx={{
                            '& > :not(style)': {
                              width: '90%'
                            }
                          }}
                          noValidate
                          autoComplete="off">
                          <TextField
                            id="outlined-basic"
                            label="city"
                            variant="outlined"
                            size="small"
                            InputProps={{
                              style: {
                                borderRadius: '20px',
                                backgroundColor: 'white'
                              }
                            }}
                            required
                          />
                        </Box>
                      </div>
                      <div className="country">
                        <Typography variant="h6" gutterBottom>
                          Country
                        </Typography>
                        <Box
                          component="form"
                          sx={{
                            '& > :not(style)': {
                              width: '100%',
                              borderRadius: '20px'
                            }
                          }}
                          noValidate
                          autoComplete="off">
                          <TextField
                            id="outlined-basic"
                            label="country"
                            variant="outlined"
                            size="small"
                            InputProps={{
                              style: {
                                borderRadius: '20px',
                                backgroundColor: 'white'
                              }
                            }}
                            required
                          />
                        </Box>
                      </div>
                    </div>
                  </Grid>
                </div>
              </Grid>
            </Grid>
          </Box>
        </div>
        <div className="submit">
          <div></div>
          <ThemeProvider theme={theme}>
            <Button variant="contained" color="primary">
              Next
            </Button>
          </ThemeProvider>
        </div>
      </div>
    </div>
  );
}
export default Reservation;
