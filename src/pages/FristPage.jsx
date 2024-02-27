import React from 'react';
import styled from 'styled-components';
import { GlobalStyle } from '..';
import { useNavigate } from 'react-router-dom';

export const BigDiv1 = styled.div`
  display: flex;
  width: 100%;
  height: 100vh;
  justify-content: center;
  align-items: center;
  flex-direction: column;
  gap: ${(props) => props.gap};
`;

const BigDiv2 = styled.div`
  display: flex;
  align-items: center;
  flex-direction: column;
`;

const MainImg = styled.img`
  height: 250px;
`;

const LogoStyle1 = styled.div`
  font-family: 'FlowerSalt';
  font-weight: 1000;
  font-size: 40px;
  font-style: normal;
`;

const LogoStyle2 = styled.div`
  font-size: 15px;
  color: grey;
`;

const LoginButton = styled.input`
  width: 250px;
  height: 35px;
  margin-top: 150px;
  border: none;
  color: gray;
  cursor: pointer;
`;

function Main() {
  const navigate = useNavigate();
  const LoginClick = () => {
    navigate('login');
  };

  return (
    <BigDiv1>
      <BigDiv2>
        <MainImg src='./수정저성.png' />
        <LogoStyle1>todo mate</LogoStyle1>
        <LogoStyle2>할일을 작성하고 관리하세요!</LogoStyle2>
      </BigDiv2>
      <LoginButton type='button' value='로그인' onClick={LoginClick} />
    </BigDiv1>
  );
}

export default Main;
