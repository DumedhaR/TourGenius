import React from 'react';
import NavigationBar from '../../components/Navigation/NavigationBar';
import '../../utils/AccountPage.css';
// This DataFiles are removed when components are intergrated
import Footer from '../../components/Footer/Footer';
import AccountHeader from '../../components/TravelerAccount/AccountHeader';
import AccountTabs from '../../components/TravelerAccount/AccountTabs';
import { AccountData } from './AccountData';

function TravelerAccountPage() {
  return (
    <div className="accountPage">
      <div className="travelerNavigation">
        <NavigationBar />
      </div>
      <div className="accountHeader">
        <AccountHeader
          firstName={AccountData.firstName}
          lastName={AccountData.lastName}
          profilePicture={AccountData.profilePicture}
        />
      </div>
      <div className="accountTabs">
        <AccountTabs />
      </div>
      <div className="travelerFooter">
        <Footer />
      </div>
    </div>
  );
}
export default TravelerAccountPage;
