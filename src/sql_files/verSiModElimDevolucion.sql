SELECT D.`Fecha`
FROM devolucion AS D
WHERE D.`idDevolucion`=? AND D.`Estado`='A' AND D.`Fecha` BETWEEN ? AND ?;
