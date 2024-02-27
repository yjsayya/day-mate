import React, { useState } from 'react';
import styled from 'styled-components';

const MemoContainer = styled.div`
  float: left;
  margin-left: 20px; /* 캘린더와의 간격 조정 */
`;

const MemoHeader = styled.div`
  font-family: 'Nanum Gothic', sans-serif;
  font-size: 18px;
  margin-bottom: 10px;
`;

const MemoTextarea = styled.textarea`
  width: 200px;
  height: 150px;
  font-family: 'Nanum Gothic', sans-serif;
`;

const Memo = ({ selectedDate, setSelectedDate }) => {
  const [memo, setMemo] = useState('');

  const handleMemoChange = (e) => {
    setMemo(e.target.value);
  };

  const handleSaveMemo = () => {
    // 메모 저장
    // 예: localStorage나 API를 사용하여 저장할 수 있습니다.
    console.log(`날짜 ${selectedDate}에 메모 저장: ${memo}`);
  };

  return (
    <MemoContainer>
      <MemoHeader>{selectedDate}일 메모</MemoHeader>
      <MemoTextarea value={memo} onChange={handleMemoChange} />
      <button onClick={handleSaveMemo}>저장</button>
    </MemoContainer>
  );
};

export default Memo;
