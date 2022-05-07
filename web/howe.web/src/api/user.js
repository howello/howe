import request from '@/utils/request'

export function login(data) {
  return request({
    url: '/howe/user/login',
    method: 'post',
    data
  })
}

export function getInfo(token) {
  return request({
    url: '/howe/user/info',
    method: 'get',
    params: { token }
  })
}

export function logout() {
  return request({
    url: '/howe/user/logout',
    method: 'post'
  })
}
