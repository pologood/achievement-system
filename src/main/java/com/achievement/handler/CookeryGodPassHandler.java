
package com.achievement.handler;

import com.achievement.constant.AchievementConstant;
import com.achievement.constant.Constants;
import com.achievement.domain.AchievementDTO;
import com.achievement.domain.Condition;
import com.achievement.event.AchievementEvent;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;


/**
 * CookeryGodPassHandler
 *
 * @author caisl
 * @desc 食神通行证
 * @since 2017-06-13
 */
@Component
public class CookeryGodPassHandler extends AbstractAchieveHandler {
    private static String achievementId = "c5a968a3372c474794ef670fe9ad7140";

    @Override
    protected boolean checkEvent(AchievementEvent event) {
        event.setAchievementId(achievementId);
        return true;
    }

    @Override
    protected boolean doCondition(AchievementDTO achievementDTO) {
        if (CollectionUtils.isNotEmpty(achievementDTO.getConditions())) {
            for (Condition condition : achievementDTO.getConditions()) {
                if (Constants.Achievement.COOKERY_GOD_PASS_CONDITION_KEY.equals(condition.getKey())) {
                    List<String> records = achievementRecordDAO.queryAchievementIds(achievementDTO.getCustomerRegisterId(),
                            AchievementConstant.RecordStatus.STATUS_COMPLETED);
                    List<String> achievementIds = Arrays.asList(condition.getValue().split(","));
                    short process = 0;
                    short preProcess = condition.getProcess();
                    if (CollectionUtils.isNotEmpty(achievementIds) && CollectionUtils.isNotEmpty(records)) {
                        for (String achievementId : records) {
                            if (achievementIds.contains(achievementId)) {
                                process++;
                            }
                        }
                        condition.setProcess(process);
                        if (process == achievementIds.size()) {
                            achievementDTO.setStatus(AchievementConstant.RecordStatus.STATUS_COMPLETED);
                        } else if (process > preProcess) {
                            //进度有更新
                            achievementDTO.setStatus(AchievementConstant.RecordStatus.STATUS_PROCESSING);
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
