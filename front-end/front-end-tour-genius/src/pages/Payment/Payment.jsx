import React from 'react';
import NavigationBar from '../../components/Navigation/NavigationBar';
import '../../utils/payment.css';
import Footer from '../../components/Footer/Footer';
import { PayPalScriptProvider, PayPalButtons } from '@paypal/react-paypal-js';

function Payment() {
  // Dummy data from backend
  const priceSummaryData = {
    originalPrice: 100,
    discount: 0,
    total: 80
  };

  return (
    <div className="home">
      <div className="navigation">
        <NavigationBar />
      </div>

      <div className="green-bar">
        <div className="text-container">
          <div className="line1">Make Payment Now to Complete</div>
          <div className="line2">Your Booking!</div>
        </div>
      </div>

      <div className="main">
        <div className="price-summary">
          <div className="price-content">
            <div className="title">Your Price Summary</div>
            <div className="info">
              <div className="info-item">
                <span className="info-label">Original Price:</span>
                <span className="info-value">${priceSummaryData.originalPrice}</span>
              </div>
              <div className="info-item">
                <span className="info-label">Discount:</span>
                <span className="info-value">${priceSummaryData.discount}</span>
              </div>
            </div>
            <div className="total-price">
              Total Pay Amount
              <br />
              <span className="amount">
                ${priceSummaryData.originalPrice - priceSummaryData.discount}
              </span>
            </div>
            <div className="pay-button">
              <PayPalScriptProvider
                options={{
                  clientId:
                    'AX8NnYx4DyADqUm_Yk17YA4H41__a1FrC2qQ6Nck0IiIylQxWNQ2uIn9gv50vfrlMcxKZkn8bZYhZvg-'
                }}>
                <PayPalButtons
                  createOrder={(data, actions) => {
                    return actions.order.create({
                      purchase_units: [
                        {
                          amount: {
                            value: priceSummaryData.total
                          }
                        }
                      ]
                    });
                  }}
                  onApprove={(data, actions) => {
                    return actions.order.capture().then((details) => {
                      const name = details.payer.name.given_name;
                      alert(`Transaction completed by ${name}`);
                    });
                  }}
                />
              </PayPalScriptProvider>
            </div>
          </div>
        </div>
      </div>

      <div className="footerHome">
        <Footer />
      </div>
    </div>
  );
}

export default Payment;
