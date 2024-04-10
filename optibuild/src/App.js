import { BrowserRouter as Router, Route, Routes} from 'react-router-dom';
import Survey from './Survey.js';
import SubmissionPage from './SubmissionPage.js';
import Cover from './Cover.js';

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/cover" element={<Cover />}/>
        <Route path="/" element={<Survey />} />
        <Route path="/submission" element={<SubmissionPage />} />
      </Routes>
    </Router>
  );
}

export default App;