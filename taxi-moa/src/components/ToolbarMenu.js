import { React, useState } from "react";
import { Link } from "react-router-dom";
import styles from "./ToolbarMenu.module.css";

function ToolbarMenu() {
  const [selected, setSelected] = useState("home");

  const onClick = (e) => {
    setSelected(e.target.id);
    console.log(e.target.id);
  };

  return (
    <div>
      <ul className={styles.MenuUl}>
        <li className={styles.MenuLi}>
          <Link
            className={
              selected === "home"
                ? styles.selectedCategory
                : styles.unselectedCategory
            }
            id="home"
            to="/"
            onClick={onClick}
          >
            Home
          </Link>
        </li>
        <li className={styles.MenuLi}>
          <Link
            className={
              selected === "about"
                ? styles.selectedCategory
                : styles.unselectedCategory
            }
            id="about"
            to="/about"
            onClick={onClick}
          >
            About
          </Link>
        </li>
      </ul>
    </div>
  );
}

export default ToolbarMenu;
