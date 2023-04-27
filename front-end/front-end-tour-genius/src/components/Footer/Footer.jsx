import React from 'react';
import '../../utils/footer.css';
import CssBaseline from '@mui/material/CssBaseline';
import Link from '@mui/material/Link';

function Footer() {
  return (
    <>
      <CssBaseline />
      <div className="footer">
        <div>
          <h2 id="tourGeniuz">TourGeniuz</h2>
          <h3 id="sriLanka">Sri Lanka</h3>
        </div>
        <div className="content">
          <div id="subContent">
            <h4>CONNECT WITH US</h4>
            <Link href="#" color="black" underline="hover">
              Instagram
            </Link>
            <br />
            <Link href="#" color="black" underline="hover">
              Twitter
            </Link>
            <br />
            <Link href="#" color="black" underline="hover">
              Facebook
            </Link>
            <br />
            <Link href="#" color="black" underline="hover">
              LinkedIn
            </Link>
          </div>
          <div id="subContent">
            <h4>LOCATIONS</h4>
            Colombo
            <br /> Mal Rd 03
            <br /> Western Province
            <br /> Sri Lanka
          </div>
          <div id="subContent">
            <p id="addressNZ">
              Me Sapa Loke
              <br /> Heaven Rd
              <br /> 135 0570
              <br /> Oslo New Zealand
            </p>
          </div>
          <div id="subContent">
            <p id="addressENG">
              Mathara
              <br /> ApeShamal
              <br /> Rd London N1 4JX
              <br /> Dakunu Rata
            </p>
          </div>
        </div>
      </div>
    </>
  );
}

export default Footer;
