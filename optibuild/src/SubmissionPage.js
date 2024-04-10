import React, { useState, useEffect } from 'react';
import './Submission.css';

function Submission() {
    useEffect(() => {
        // Set the body background color to white using hexadecimal
        document.body.style.backgroundColor = '#202e3b'; // White color
        
        // Cleanup function to reset the background color when the component unmounts
        return () => {
          document.body.style.backgroundColor = ''; // Revert to the default
        };
    }, []);

    // Add this inside your Submission component
    const [selectedCell, setSelectedCell] = useState(null);
    function handleCellClick(cellData) {
        setSelectedCell(null);
        setTimeout(() => {
            setSelectedCell(cellData); // Then, set the new cell data after a short delay
          }, 10); 
        // setSelectedCell(cellData);
      }

    const data = [{ 
        'CPU': 'AMD Ryzen 3800X', 
        'GPU': 'EVGA RTX 2060', 
        'Memory': '16 GB DDR4', 
        'Motherboard': 'MSI X470 GAMING EDGE WIFI', 
        'Case': 'ATX',
        'CPU Cooler': 'AMD Prism',
        'Fans': '6 x 120mm',
        'Hard Drive': '1 TB SSD',
        'Power Supply': 'EVGA GOLD 800W'
    }];

    function VerticalTable({ data, onCellClick }) {
        // Assuming `data` is an array of objects, and we take the first one to create headers
        const headers = Object.keys(data[0]);
        console.log('header is:', headers);
        return (
          <table>
            <tbody>
              {headers.map(header => (
                <tr key={header}>
                  <th>{header}</th>
                    <td onClick={() => onCellClick({ header, value: data[0][header] })}>
                        {data[0][header]}
                    </td>
                  {/* {data.map((item, index) => (
                    <td key={index}>{item[header]}</td>
                  ))} */}
                </tr>
              ))}
            </tbody>
          </table>
        );
    }


    return(
        <div className='table-container'>
            <h1>Your Build</h1>
                <VerticalTable data={data} onCellClick={handleCellClick} />
                {selectedCell && (
                <div className='pop-out-table'>
                    <h1>Options</h1>
                    <p><strong>Current {selectedCell.header}:</strong> {selectedCell.value}</p>
                    {/* Render additional details or another table based on selectedCell */}
                    <table>
                        <thead>
                            <tr>
                                <th>{selectedCell.header}</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>Nothing</td>
                            </tr>
                            <tr>
                                <td>Nothing</td>
                            </tr>
                            <tr>
                                <td>Nothing</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                )}
            {/* <table>
                <thead>
                <tr>
                    <th>CPU</th>
                    <th>GPU</th>
                    <th>Memory</th>
                    <th>Motherboard</th>
                    <th>Case</th>
                    <th>CPU Cooler</th>
                    <th>Fans</th>
                    <th>Hard Drive (read/write)</th>
                    <th>Hard Drive 2 (read/write)</th>
                    <th>Hard Drive 3 (read/write)</th>
                    <th>Power Supply</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>AMD Ryzen 3800X</td>
                    <td>EVGA RTX 2060</td>
                    <td>16 GB DDR4</td>
                    <td>MSI X470 GAMING EDGE WIFI</td>
                    <td>ATX</td>
                    <td>AMD Prism</td>
                    <td>6 x 120mm</td>
                    <td>1 TB SSD (7000/6000)</td>
                    <td>1 TB HDD (400/300)</td>
                    <td>1 TB SSD (3800/2000)</td>
                    <td>EVGA GOLD 800W</td>
                </tr>
                </tbody>
            </table> */}
        </div>
    )
}

export default Submission;
