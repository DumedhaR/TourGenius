import React from 'react';
import NavigationBar from '../../components/Navigation/NavigationBar';
import '../../utils/AccountPage.css';
// This DataFiles are removed when components are intergrated
import Footer from '../../components/Footer/Footer';
import ClientAccountHeader from '../../components/ClientAccount/ClientAccountHeader';
import { ClientAccountData } from './ClientAccountData';
import ClientAccountTabs from '../../components/ClientAccount/ClientAccountTabs';

function ClientAccountPage() {
  return (
    <div className="accountPage">
      <div className="clientNavigation">
        <NavigationBar />
      </div>
      <div className="accountHeader">
        <ClientAccountHeader
          firstName={ClientAccountData.firstName}
          lastName={ClientAccountData.lastName}
          propertyName={ClientAccountData.propertyName}
        />
      </div>
      <div className="accountTabs">
        <ClientAccountTabs />
      </div>
      <div className="clientFooter">
        <Footer />
      </div>
    </div>
  );
}
export default ClientAccountPage;
