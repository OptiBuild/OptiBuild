# OptiBuild Project

## Overview

## Front End Description

This project is a web application developed using React.js. It includes several key components that are currently in use:

* Survey.js: The main component that orchestrates the rendering of other components. This java script file contains both cover page of our product and the survey for the user to answer. 
* ProgressBar.js: A separate component that interact with the Survey.js to show the user the progress they have made for the survey. 
* Submission.js: A component that shows the final build of the user's personalised computer. 

Each of these components is styled with its corresponding CSS file.

## Setup
### Prerequisites

### Installation

#### Back End:
- Server: 

- API Requests:

- Database:

#### Front End:
1. Clone the repository to your local machine.
2. Navigate to the project directory.
3. Run npm install to install all the necessary dependencies.

### Running the Application

Start the frontend by running `npm start` in the project directory. Open your web browser and go to http://localhost:3000 to view the application.

Start the whole client application (React SocketCounter.js and Client.js) by running `npm concurrent start`

**Make sure to adjust the IP address and port number in Client.js to the specified server location.**

## Usage

* Cover Component: Interact with the cover page to navigate through to the survey component. 
* Survey Component: Fill in the required fields to simulate the answering process.
* Submission Component: This component will connect to out database server and display real-time data regarding the personal computer. Ensure the server is running and accessible.

## Contributing

* Contributions to this project are welcome. Please follow these steps to contribute:

1. Fork the repository.
2. Create a new branch for your feature.
3. Commit your changes.
4. Push to the branch.
5. Create a new Pull Request.