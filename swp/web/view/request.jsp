<%-- 
    Document   : request
    Created on : Jan 18, 2024, 11:44:00 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Create Request</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #f4f4f4;
      margin: 0;
      padding: 0;
    }

    .container {
      max-width: 600px;
      margin: 50px auto;
      background-color: #fff;
      padding: 20px;
      border-radius: 5px;
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }

    label {
      display: block;
      margin-bottom: 8px;
    }

    input, textarea, select {
      width: 100%;
      padding: 8px;
      margin-bottom: 16px;
      box-sizing: border-box;
      border: 1px solid #ccc;
      border-radius: 4px;
    }

    .checkbox-group {
      margin-bottom: 16px;
    }

    button {
      background-color: #4caf50;
      color: #fff;
      padding: 10px 15px;
      border: none;
      border-radius: 4px;
      cursor: pointer;
    }

    button:hover {
      background-color: #45a049;
    }
  </style>
</head>
<body>

  <div class="container">
    <h2>Create Request</h2>
    <form id="createRequestForm">
      <label for="title">Title:</label>
      <input type="text" id="title" name="title" required>

      <label for="deadlineDate">Deadline Date:</label>
      <input type="date" id="deadlineDate" name="deadlineDate" required>

      <label for="deadlineHour">Deadline Hour:</label>
      <input type="time" id="deadlineHour" name="deadlineHour" required>

      <label for="content">Content of Request:</label>
      <textarea id="content" name="content" rows="4" required></textarea>

      <label class="checkbox-group">Select Skills (max 3):</label>
      <label><input type="checkbox" name="skill" value="skill1"> Skill 1</label>
      <label><input type="checkbox" name="skill" value="skill2"> Skill 2</label>
      <label><input type="checkbox" name="skill" value="skill3"> Skill 3</label>
      <label><input type="checkbox" name="skill" value="all"> All</label>

      <label for="programmingLanguage">Programming Language (Framework):</label>
      <select id="programmingLanguage" name="programmingLanguage" required>
        <option value="language1">Language</option>
        <option value="language2">Language 2</option>
        <option value="language3">Language 3</option>
      </select>

      <label for="status">Status:</label>
      <select id="status" name="status" required>
        <option value="Open">Open</option>
        <option value="Processing">Processing</option>
        <option value="Cancel">Cancel</option>
        <option value="Closed">Closed</option>
      </select>

      <button type="submit">OK</button>
    </form>
  </div>

</body>
</html>