import React from 'react';
import { Route, Routes } from 'react-router-dom';
import Toolbar from './components/Toolbar';
import Main from './components/Main';
import Hello2 from './components/Hello2';

function App() {
  return (
    <>
      <Toolbar/>
      <Routes>
        <Route path="/" element={<Main />} />
        <Route path="/about" element={<Hello2 />} />
      </Routes>
    </>
  );
}

export default App;