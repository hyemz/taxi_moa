import React from 'react';
import { Route, Routes } from 'react-router-dom';
import Toolbar from './components/Toolbar';
import Hello1 from './components/Hello';
import Hello2 from './components/Hello2';

function App() {
  return (
    <div>
      <Toolbar/>
      <Routes>
        <Route path="/" element={<Hello1 />} />
        <Route path="/about" element={<Hello2 />} />
      </Routes>
    </div>
  );
}

export default App;