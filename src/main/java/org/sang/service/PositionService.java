package org.sang.service;

import java.util.List;

import org.sang.bean.Position;
import org.sang.mapper.PositionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by sang on 2018/1/10.
 */
@Service
@Transactional
public class PositionService {
    @Autowired
    PositionMapper positionMapper;

    public int addPos(Position pos) {
        if (positionMapper.getPosByName(pos.getName()) != null) {
            return -1;
        }
        return positionMapper.addPos(pos);
    }

    public List<Position> getAllPos() {
        return positionMapper.getAllPos();
    }

    public boolean deletePosById(String pids) {
        String[] split = pids.split(",");
        return positionMapper.deletePosById(split) == split.length;
    }

    public int updatePosById(Position position) {
        return positionMapper.updatePosById(position);
    }

}
