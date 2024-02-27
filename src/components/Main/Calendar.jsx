import React, { useState } from 'react';
import styled from 'styled-components';
import { BsChevronLeft, BsChevronRight } from 'react-icons/bs';
import Memo from './Memo'; // Memo 컴포넌트 추가

const CalendarContainer = styled.div`
  float: left;
`;

const CalendarHeader = styled.div`
  display: flex;
  align-items: center;
  justify-content: space-between;
  margin-bottom: 10px;
  font-family: 'Nanum Gothic', sans-serif;
`;

const MonthSelector = styled.select`
  margin-right: 10px;
`;

const YearSelector = styled.input`
  width: 70px;
  margin-right: 10px;
`;

const CalendarTable = styled.table`
  border-collapse: collapse;
  font-family: 'Nanum Gothic', sans-serif;
`;

const CalendarCell = styled.td`
  padding: 10px;
  border: 1px solid #ccc;
  font-family: 'Nanum Gothic', sans-serif;
  text-align: center;
  cursor: pointer;
`;

const Calendar = () => {
  const [year, setYear] = useState(new Date().getFullYear());
  const [month, setMonth] = useState(new Date().getMonth() + 1);
  const [selectedDate, setSelectedDate] = useState(null);

  const daysInMonth = (year, month) => {
    return new Date(year, month, 0).getDate();
  };

  const generateCalendar = (year, month) => {
    const firstDay = new Date(year, month - 1, 1).getDay();
    const totalDays = daysInMonth(year, month);
    const calendar = [];

    let dayCounter = 1;
    for (let i = 0; i < 6; i++) {
      const week = [];
      for (let j = 0; j < 7; j++) {
        if (i === 0 && j < firstDay) {
          week.push('');
        } else if (dayCounter > totalDays) {
          break;
        } else {
          week.push(dayCounter);
          dayCounter++;
        }
      }
      calendar.push(week);
      if (dayCounter > totalDays) {
        break;
      }
    }

    return calendar;
  };

  const handleMonthChange = (e) => {
    setMonth(parseInt(e.target.value));
  };

  const handleYearChange = (e) => {
    setYear(parseInt(e.target.value));
  };

  const handlePrevMonth = () => {
    if (month === 1) {
      setMonth(12);
      setYear(year - 1);
    } else {
      setMonth(month - 1);
    }
  };

  const handleNextMonth = () => {
    if (month === 12) {
      setMonth(1);
      setYear(year + 1);
    } else {
      setMonth(month + 1);
    }
  };

  const handleDateClick = (day) => {
    setSelectedDate(day);
  };

  const renderCalendar = () => {
    const calendar = generateCalendar(year, month);
    return (
      <CalendarTable>
        <thead>
          <tr>
            <CalendarCell colSpan='7'>
              {year}년 {month}월
            </CalendarCell>
          </tr>
          <tr>
            <CalendarCell>일</CalendarCell>
            <CalendarCell>월</CalendarCell>
            <CalendarCell>화</CalendarCell>
            <CalendarCell>수</CalendarCell>
            <CalendarCell>목</CalendarCell>
            <CalendarCell>금</CalendarCell>
            <CalendarCell>토</CalendarCell>
          </tr>
        </thead>
        <tbody>
          {calendar.map((week, weekIndex) => (
            <tr key={weekIndex}>
              {week.map((day, dayIndex) => (
                <CalendarCell
                  key={dayIndex}
                  onClick={() => handleDateClick(day)}
                  style={{
                    backgroundColor:
                      day === selectedDate ? 'lightblue' : 'inherit',
                  }}
                >
                  {day}
                </CalendarCell>
              ))}
            </tr>
          ))}
        </tbody>
      </CalendarTable>
    );
  };

  return (
    <CalendarContainer>
      <CalendarHeader>
        <div>
          <BsChevronLeft
            onClick={handlePrevMonth}
            style={{ cursor: 'pointer' }}
          />
          <MonthSelector value={month} onChange={handleMonthChange}>
            <option value={1}>1월</option>
            <option value={2}>2월</option>
            <option value={3}>3월</option>
            <option value={4}>4월</option>
            <option value={5}>5월</option>
            <option value={6}>6월</option>
            <option value={7}>7월</option>
            <option value={8}>8월</option>
            <option value={9}>9월</option>
            <option value={10}>10월</option>
            <option value={11}>11월</option>
            <option value={12}>12월</option>
          </MonthSelector>
          <YearSelector
            type='number'
            value={year}
            onChange={handleYearChange}
          />
          <BsChevronRight
            onClick={handleNextMonth}
            style={{ cursor: 'pointer' }}
          />
        </div>
      </CalendarHeader>
      {renderCalendar()}
      {selectedDate && (
        <Memo selectedDate={selectedDate} setSelectedDate={setSelectedDate} />
      )}
    </CalendarContainer>
  );
};

export default Calendar;
