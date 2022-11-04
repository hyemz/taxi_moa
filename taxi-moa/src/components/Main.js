import React from 'react';
import TaxiCard from './TaxiCard';
import styles from './Main.module.css';

function Main() {
  return <div className={styles.Background}>
    <TaxiCard/>
  </div>
}

export default Main;