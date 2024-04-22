import React, { useState, useEffect } from 'react';
import './Submission.css';
import { useLocation } from 'react-router-dom';

function Submission() {

  // const location = useLocation();
  // const datas = location.state.data;
  // console.log(datas)

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
        'Case': 'ATX Full Tower',
        'CPU Cooler': 'AMD Prism',
        'Hard Drive': '1 TB SSD',
        'Power Supply': 'EVGA GOLD 800W'
    }];

    const popoutData = [{
      'CPU': ['Ryzen 7 7700', 'Ryzen 5 7600', 'Core i5-14600K'],
      'GPU': ['GeForce RTX 4090 D', 'GeForce RTX 4070 Ti SUPER', 'GeForce RTX 3090 Ti'],
      'Memory': ['Trident Z5 RGB', 'Vengeance LPX', 'ViperSteel'],
      'Motherboard': ['B650M Pro RS WIFI', 'TUF Gaming B650-E WIFI', 'Z690 PG VELOCITA'], 
      'Case': ['m-ATX', 'ATX Mid Tower', 'ITX'],
      'CPU Cooler': ['Dark Rock Pro 5', 'V6', 'UX200 Special Edition'], 
      'Hard Drive': ['Blue HDD', 'FireCuda HDD', 'BLACK SN850X NVMe'],
      'Power Supply': ['RM1000e', 'XP1000W 80PLUS PLATINUM', 'SFX Series']
    }]

    function VerticalTable({ data, onCellClick }) {
        // Assuming `data` is an array of objects, and we take the first one to create headers
        const headers = Object.keys(data[0]);
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

    function PopoutTable() {
      console.log(popoutData[selectedCell.header])
      return (
        <div className='pop-out-table'>
          <h1>Options</h1>
          <p><strong>Current {selectedCell.header}:</strong> {selectedCell.value}</p>
          <a href="https://www.amazon.com/AMD-Ryzen-5800X-16-Thread-Processor/dp/B0815XFSGK/ref=sr_1_3?dib=eyJ2IjoiMSJ9.NvasPuvyAu0Xd0EoYZ_S3gqRI6EENJiqccVTjIuwQJz0LjS6Q8f27IKYcS1OnCeap-Ef3vfgsy3Q1EQ118aYEy_Yvt_LMTK4yhh2O3DQ5srHZ7Jpd5U1NhdXTYdf-_-EtNFKILk9Y19cQ32LYaYAtvqZkdzSvOfsrSejN_AN2INYKdF76gaDYZ9CMYwv74koMnJsA9CSCCe91GxeSaJbMYWWM7ltcg4666aE5V4X8lA.lFdSZLJy-B0D1_thzE9xU-GU7QYa_p40WMkuKGWDldQ&dib_tag=se&keywords=AMD%2BRyzen%2B3800X&qid=1712825099&sr=8-3&th=1"><strong>Link</strong></a>
          {/* Render additional details or another table based on selectedCell */}
          <table>
              <thead>
                  <tr>
                      <th>{selectedCell.header}</th>
                  </tr>
              </thead>
              <tbody>
                  <tr>
                      <td>{popoutData[0][selectedCell.header][0]}</td>
                  </tr>
                  <tr>
                      <td>{popoutData[0][selectedCell.header][1]}</td>
                  </tr>
                  <tr>
                      <td>{popoutData[0][selectedCell.header][2]}</td>
                  </tr>
              </tbody>
          </table>
        </div>
      )
    }

    return(
        <div className='table-container'>
            <h1>Your Build</h1>
                <VerticalTable data={data} onCellClick={handleCellClick} />
                {selectedCell && ( PopoutTable())}
        </div>
    )
}

export default Submission;
