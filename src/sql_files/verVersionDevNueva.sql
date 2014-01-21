SELECT D.`idVersionDev`
FROM devolucion AS D
WHERE D.`idDevolucion`=? AND D.Estado='A';
