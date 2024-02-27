import React from 'react';
import { BigDiv1 } from './FristPage';
import styled from 'styled-components';

const TopBack = styled.div`
  display: flex;
  justify-content: space-between;
  border: 1px solid green;
  width: 400px;
`;

const InputStyle = styled.input`
  width: 400px;
`;

function Login() {
  return (
    <BigDiv1 gap='5px'>
      <TopBack>
        <div>ㅇ</div> <div>로그인</div> <div></div>
      </TopBack>
      <InputStyle placeholder='이메일' />
      <InputStyle placeholder='비밀번호' />
      <input type='button' value='확인' />
    </BigDiv1>
  );
}

export default Login;
