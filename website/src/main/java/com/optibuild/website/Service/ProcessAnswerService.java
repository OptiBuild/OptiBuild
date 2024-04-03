package com.optibuild.website.Service;

import com.optibuild.website.model.Answer;
import com.optibuild.website.model.GameRequirement;
import com.optibuild.website.repository.GameRequirementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProcessAnswerService {
    //inject repository
    private final GameRequirementRepository gameRequirementRepository;

    @Autowired
    public ProcessAnswerService(GameRequirementRepository gameRequirementRepository) {
        this.gameRequirementRepository = gameRequirementRepository;
    }

    public List<Answer> processAnswers(Object answers) {
        if (!(answers instanceof List<?>)) {
            return null;
        }

        List<?> answersList = (List<?>) answers;
        List<Answer> processedAnswers = new ArrayList<>();

        // process different answer types
        for (Object obj : answersList) {
            if (obj instanceof String) {
                List<String> choices = new ArrayList<>();
                choices.add((String) obj);
                Answer answer = new Answer(processedAnswers.size(), choices);
                processedAnswers.add(answer);
            } else if (obj instanceof List<?>) {
                List<String> choices = (List<String>) obj;
                Answer answer = new Answer(processedAnswers.size(), choices);
                processedAnswers.add(answer);
            }
        }

        return processedAnswers;
    }

    public List<List<String>> parseAnswer(List<Answer> answers) {
        List<List<String>> parseAnswer = new ArrayList<>();
        //Question1: Budget
        int index = 0;
        parseAnswer.add(processBudget(answers.get(index)));

        //Question2: Do you like to leave your software running? (CPU)
        index++;
        boolean leaveRunning = processBooleanQuestion(answers.get(index));
        if (leaveRunning) {
            index++;
            leaveRunning = processBooleanQuestion(answers.get(index));
        }
        List<String> cpu = new ArrayList<>();
        if (leaveRunning) {
            cpu.add("Core i7-14700K");
            //cpu.add("Intel Core i9-14900K");
        } else {
            cpu.add("Core i5-14600K"); //Default
        }
        parseAnswer.add(cpu);

        //Question3: What specific programs will you be using?
        index++;
        List<String> gpu = new ArrayList<>();
        if (processQuestion3(answers.get(index))) {
            gpu.add("Default");
        } else {
            gpu.add("NONE");
        }
        parseAnswer.add(gpu);

        //Question4: Will you be playing games? (need graphics card) (need CPU)
        index++;
        List<String> gamelist = new ArrayList<>();
        if(processBooleanQuestion(answers.get(index))) {
            index++;
            gamelist = answers.get(index).getChoices();
        }

        //Question5: How much storage do you think you will need?
        index++;
        List<String> harddrive = new ArrayList<>();
        harddrive.add(processQuestion5(answers.get(index)));
        parseAnswer.add(harddrive);

        //Question6: Where do you plan to place your PC?
        index++;
        List<String> pccase = new ArrayList<>();
        pccase.add(answers.get(index).getChoices().get(0));
        parseAnswer.add(pccase);

        //Question7: Do you plan to upgrade your PC in the future?
        index++;
        List<String> motherboard = new ArrayList<>();
        if(processBooleanQuestion(answers.get(index))) {
            motherboard.add("Upgrade");
        } else {
            motherboard.add("Default");
        }
        parseAnswer.add(motherboard);

        //Question8: How many tabs do you like to keep open at once?
        index++;
        List<String> ram = new ArrayList<>();
        ram.add(processQuestion8(answers.get(index)));
        parseAnswer.add(ram);

        //process game list


        return parseAnswer;
    }

    private void processGameList(List<String> gamelist, List<List<String>> parseAnswer) {
        for (String gameName : gamelist) {
            GameRequirement gameRequirement = gameRequirementRepository.findByNameAndPcRequirements(gameName, "Minimum");

            if (gameRequirement != null) {
                updateCpuInParsedAnswer(parseAnswer, gameRequirement.getProcessor());
                updateGpuInParsedAnswer(parseAnswer, gameRequirement.getGraphics());
                updateStorageInParsedAnswer(parseAnswer, gameRequirement.getStorage());
                updateMemoryInParsedAnswer(parseAnswer, gameRequirement.getMemory());
            }
        }
    }

    private void updateCpuInParsedAnswer(List<List<String>> parseAnswer, String processor) {
        List<String> cpu = parseAnswer.get(1);
        if (!cpu.contains(processor)) cpu.add(processor);
    }

    private void updateGpuInParsedAnswer(List<List<String>> parseAnswer, String graphics) {
        List<String> gpu = parseAnswer.get(2);
        if(!gpu.contains(graphics)) gpu.add(graphics);
    }

    private void updateStorageInParsedAnswer(List<List<String>> parseAnswer, int storage) {
        List<String> hd = parseAnswer.get(3);//hard drive
        String stringStorage = String.valueOf(storage);
        if(!hd.contains(stringStorage)) hd.add(stringStorage);
    }

    private void updateMemoryInParsedAnswer(List<List<String>> parseAnswer, int memory) {
        List<String> ram = parseAnswer.get(6);
        String stringMemory = String.valueOf(memory);
        if(!ram.contains(stringMemory)) ram.add(String.valueOf(stringMemory));
    }

    private String processQuestion8(Answer answer) {
        if("0-15".equals(answer.getChoices().get(0))) return "8";
        if("15-30".equals(answer.getChoices().get(0))) return "16";
        return "32";
    }

    private String processQuestion5(Answer answer) {
        if("250GB-500GB".equals(answer.getChoices().get(0))) return "500";
        if("500GB-1TB".equals(answer.getChoices().get(0))) return "1024";
        if("1TB-2TB".equals(answer.getChoices().get(0))) return "1524";
        if("2TB-4TB".equals(answer.getChoices().get(0))) return "3072";
        return "4096";
    }

    private boolean processQuestion3(Answer answer) {
        for (String a : answer.getChoices()) {
            if (a.equals("Adobe Premiere Pro") || a.equals("Adobe After Effects")) return true;
        }
        return false;
    }

    private List<String> processBudget(Answer budgetAnswer) {
        int budget = Integer.parseInt(budgetAnswer.getChoices().get(0));
        List<String> processBudget = new ArrayList<>();
        processBudget.add(determineBudgetRange(budget));
        return processBudget;
    }

    private boolean processBooleanQuestion(Answer answer) {
        return "yes".equals(answer.getChoices().get(0));
    }


    private String determineBudgetRange(int budget) {
        if (budget < 500) return "500";
        if (budget <= 800) return "800";
        if (budget <= 1000) return "1000";
        if (budget <= 1300) return "1300";
        if (budget <= 1500) return "1500";
        if (budget <= 1700) return "1700";
        if (budget <= 2000) return "2000";
        if (budget <= 3000) return "3000";
        return "5000";
    }


}
