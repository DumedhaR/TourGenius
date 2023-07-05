import * as React from 'react';
import PropTypes from 'prop-types';
import Tabs from '@mui/material/Tabs';
import Tab from '@mui/material/Tab';
import Typography from '@mui/material/Typography';
import Box from '@mui/material/Box';
import { createTheme, ThemeProvider } from '@mui/material/styles';
import BookingContainer from './BookingContainer';
import '../../utils/BookingContainer.css';

function CustomTabPanel(props) {
  const { children, value, index, ...other } = props;

  return (
    <div
      role="tabpanel"
      hidden={value !== index}
      id={`simple-tabpanel-${index}`}
      aria-labelledby={`simple-tab-${index}`}
      {...other}>
      {value === index && (
        <Box sx={{ p: 3 }}>
          <Typography>{children}</Typography>
        </Box>
      )}
    </div>
  );
}

CustomTabPanel.propTypes = {
  children: PropTypes.node,
  index: PropTypes.number.isRequired,
  value: PropTypes.number.isRequired
};

function a11yProps(index) {
  return {
    id: `simple-tab-${index}`,
    'aria-controls': `simple-tabpanel-${index}`
  };
}

function AccountTabs() {
  const [value, setValue] = React.useState(0);

  const handleChange = (event, newValue) => {
    setValue(newValue);
  };

  const theme = createTheme({
    palette: {
      primary: {
        main: '#FFFFFF',
        darker: '#4DA343',
        contrastText: '#4DA343'
      },
      secondary: {
        main: '#4DA343'
      }
    }
  });

  return (
    <Box sx={{ width: '100%' }}>
      <ThemeProvider theme={theme}>
        <Box sx={{ borderBottom: 1, borderColor: 'divider' }}>
          <Tabs
            value={value}
            onChange={handleChange}
            aria-label="account-features"
            textColor="secondary"
            indicatorColor="secondary">
            <Tab label="Bookings" {...a11yProps(0)} />
            <Tab label="Comments" {...a11yProps(1)} />
            <Tab label="Payments" {...a11yProps(2)} />
          </Tabs>
        </Box>
      </ThemeProvider>

      <div className="tabBody">
        <CustomTabPanel value={value} index={0}>
          <BookingContainer />
        </CustomTabPanel>
      </div>
      <div className="tabBody">
        <CustomTabPanel value={value} index={1}></CustomTabPanel>
      </div>
      <div className="tabBody">
        <CustomTabPanel value={value} index={2}></CustomTabPanel>
      </div>
    </Box>
  );
}
export default AccountTabs;
