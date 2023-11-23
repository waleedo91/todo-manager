package com.waleed.todomanager.controller;

import com.waleed.todomanager.dto.TodoDto;
import com.waleed.todomanager.entity.Todo;
import com.waleed.todomanager.service.TodoService;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/todos")
public class TodoController {

    private TodoService todoService;

    // Add Todo API
    @PostMapping
    public ResponseEntity<TodoDto> createTodo(@RequestBody TodoDto todoDto){
        TodoDto savedTodo = todoService.addTodo(todoDto);
        return new ResponseEntity<>(savedTodo, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<TodoDto> getTodoById(@PathVariable("id") Long todoId){
        TodoDto todoDto = todoService.getTodo(todoId);
        return new ResponseEntity<>(todoDto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<TodoDto>> getAllTodos(){
        List<TodoDto> todos = todoService.getAllTodos();
        return ResponseEntity.ok(todos);
    }

    @PutMapping("{id}")
    public ResponseEntity<TodoDto> updateTodo(@PathVariable("id") Long todoId,
                                              @RequestBody TodoDto todoDto) {
        TodoDto updatedTodo = todoService.updateTodo(todoId, todoDto);
        return ResponseEntity.ok(updatedTodo);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable("id") Long todoId){
        todoService.deleteTodo(todoId);
        return ResponseEntity.ok("Todo Deleted Successfully");
    }
}
