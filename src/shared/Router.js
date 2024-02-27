import React from 'react';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import FristPage from '../pages/FristPage';
import Login from '../pages/Login';
import Main from '../pages/Main';

function Router() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path='/' element={<FristPage />} />
        <Route path='login' element={<Login />} />
        <Route path='main' element={<Main />} />
      </Routes>
    </BrowserRouter>
  );
}

export default Router;
