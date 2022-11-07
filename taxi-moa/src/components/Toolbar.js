import React from "react";
import styles from "./Toolbar.module.css";
import ToolbarMenu from "./ToolbarMenu";

function Toolbar() {
  return (
    <div className={styles.Background}>
      <tr>
        <td>
          <img className={styles.LogoImage} alt="Logo" src="img/Taximoa.png" />
        </td>
        <td>
          <ToolbarMenu />
        </td>
      </tr>
    </div>
  );
}

export default Toolbar;
