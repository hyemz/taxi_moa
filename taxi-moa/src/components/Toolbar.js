import React from 'react';
import styles from './Toolbar.module.css';
import { Link } from 'react-router-dom';

function Toolbar() {
  return <div className={styles.Background}>
      <tr>
        <td><img className={styles.LogoImage} alt="Logo" src="img/Logo.png"/></td>
        <td><h className={styles.Title}>TaxiMoa</h></td>
        <td>
          <ul>
            <li>
              <Link to="/">홈</Link>
            </li>
            <li>
              <Link to="/about">소개</Link>
            </li>
          </ul>
        </td>
      </tr>
      
    </div>

}

export default Toolbar;