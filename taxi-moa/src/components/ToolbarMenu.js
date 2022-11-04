import React from 'react';
import { Link } from 'react-router-dom';
import styles from './ToolbarMenu.module.css';


function ToolbarMenu() {
  return <div>
          <ul className={styles.MenuUl}>
              <li className={styles.MenuLi}>
                <Link className={styles.MenuLink} to="/">Home</Link>
              </li>
              <li className={styles.MenuLi}>
                <Link className={styles.MenuLink} to="/about">Etc</Link>
              </li>
          </ul>
  </div>
}

export default ToolbarMenu;