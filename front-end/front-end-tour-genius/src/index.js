import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
//import App from './App';
import reportWebVitals from './reportWebVitals';
import AccountGreet from './components/Account/AccountGreet';
import { AccountData } from './components/Account/AccountData';
import AccountTabs from './components/Account/AccountTabs';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <AccountGreet
      firstName={AccountData.firstName}
      lastName={AccountData.lastName}
      profilePicture={AccountData.profilePicture}
    />
    <AccountTabs />
  </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
