import React, { useState } from 'react';
import styled from 'styled-components';

const TodoListContainer = styled.div`
  float: left;
  margin-right: 20px;
`;

const TodoInput = styled.input`
  margin-bottom: 10px;
`;

const TodoItem = styled.li`
  margin-bottom: 10px;
  cursor: pointer;
  ${(props) => props.completed && `text-decoration: line-through;`}
`;

const TodoList = () => {
  const [todos, setTodos] = useState([]);
  const [todoText, setTodoText] = useState('');

  const handleInputChange = (e) => {
    setTodoText(e.target.value);
  };

  const handleAddTodo = () => {
    if (todoText.trim() !== '') {
      setTodos([...todos, { text: todoText, completed: false }]);
      setTodoText('');
    }
  };

  const handleTodoClick = (index) => {
    const newTodos = [...todos];
    newTodos[index].completed = !newTodos[index].completed;
    setTodos(newTodos);
  };

  return (
    <TodoListContainer>
      <h2>Todo List</h2>
      <ul>
        {todos.map((todo, index) => (
          <TodoItem
            key={index}
            completed={todo.completed}
            onClick={() => handleTodoClick(index)}
          >
            {todo.text}
          </TodoItem>
        ))}
      </ul>
      <TodoInput
        type='text'
        value={todoText}
        onChange={handleInputChange}
        placeholder='Add new todo'
      />
      <button onClick={handleAddTodo}>Add Todo</button>
    </TodoListContainer>
  );
};

export default TodoList;
